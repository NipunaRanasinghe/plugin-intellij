/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.ballerina.plugins.idea.debugger;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.ColoredTextContainer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.xdebugger.XDebuggerUtil;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XStackFrame;
import com.intellij.xdebugger.frame.XValueChildrenList;
import org.eclipse.lsp4j.debug.Scope;
import org.eclipse.lsp4j.debug.ScopesArguments;
import org.eclipse.lsp4j.debug.ScopesResponse;
import org.eclipse.lsp4j.debug.StackFrame;
import org.eclipse.lsp4j.debug.Variable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Represents a stack frame in debug window.
 */
public class BallerinaStackFrame extends XStackFrame {

    private static final Logger LOG = Logger.getInstance(BallerinaStackFrame.class);
    private final BallerinaDebugProcess myProcess;
    private final StackFrame myFrame;

    BallerinaStackFrame(@NotNull BallerinaDebugProcess process, @NotNull StackFrame frame) {
        myProcess = process;
        myFrame = frame;
    }

    @Nullable
    @Override
    public XDebuggerEvaluator getEvaluator() {
        // Todo - Add evaluator support
        return null;
    }

    /**
     * Returns the source position. This is used to show the debug hit in the file.
     */
    @Nullable
    @Override
    public XSourcePosition getSourcePosition() {
        VirtualFile file = findFile();
        return file == null ? null : XDebuggerUtil.getInstance().createPosition(file, myFrame.getLine().intValue());
    }

    @Nullable
    private VirtualFile findFile() {
        String fileName = myFrame.getSource().getName();
        String filePath = myFrame.getSource().getPath();

        File file = searchFile(new File(filePath), fileName);
        if (file != null) {
            return LocalFileSystem.getInstance().findFileByPath(file.getAbsolutePath());
        }

        return null;

        // Todo - Add support for non-project files (standard libraries, central modules)
//        // If the file is not available locally, we use package path and file path to find the matching file in the
//        // project.
//        // if the package path is ".", full path of the file will be sent as the file name.
//        if (".".equals(packageName) && fileName.contains(File.separator)) {
//            String filePath = constructFilePath(projectBasePath, "",
//                    fileName.substring(fileName.lastIndexOf(File.separator)));
//            return LocalFileSystem.getInstance().findFileByPath(filePath);
//        } else {
//            String filePath = constructFilePath(projectBasePath, packageName, fileName);
//            VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(filePath);
//            if (virtualFile != null) {
//                return virtualFile;
//            }
//            String path = Paths.get(packageName.replaceAll("\\.", File.separator), fileName).toString();
//            return BallerinaPsiImplUtil.findFileInProjectSDK(project, path);
//        }
    }

    private File searchFile(File file, String search) {
        if (!file.isDirectory()) {
            return file.getName().equals(search) ? file : null;
        }
        File[] files = file.listFiles();
        if (files == null) {
            return null;
        }
        for (File f : files) {
            File found = searchFile(f, search);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    /**
     * Customizes the stack name in the Frames sub window in Debug window.
     */
    @Override
    public void customizePresentation(@NotNull ColoredTextContainer component) {
        super.customizePresentation(component);
        component.append(" at ", SimpleTextAttributes.REGULAR_ATTRIBUTES);
        component.append(myFrame.getName(), SimpleTextAttributes.REGULAR_BOLD_ATTRIBUTES);
        component.setIcon(AllIcons.Debugger.Frame);
    }

    /**
     * Adds variables in the current stack to the node.
     */
    @Override
    public void computeChildren(@NotNull XCompositeNode node) {

        // Todo - Enable variable support
        BallerinaDAPClientConnector dapConnector = myProcess.getDapClientConnector();
        if (!dapConnector.isConnected()) {
            LOG.warn("Debug Scope fetching failed since debug client connector is not active");
            return;
        }
        Map<String, List<Variable>> scopeMap = new HashMap<>();
        ScopesArguments scopeArgs = new ScopesArguments();
        scopeArgs.setFrameId(myFrame.getId());
        try {
            ScopesResponse scopes = dapConnector.getRequestManager().scopes(scopeArgs);
            for (Scope scope : scopes.getScopes()) {
                // Create a new XValueChildrenList to hold the XValues.
                XValueChildrenList xValueChildrenList = new XValueChildrenList();
                // Todo - Replace with the real implementation
                Variable dummyVar = new Variable();
                // Add the variables to the children list using a ValueGroup.
                xValueChildrenList.addBottomGroup(new BallerinaXValueGroup(myProcess, myFrame, scope.getName(),
                        dummyVar));
                // Add the list to the node as children.
                node.addChildren(xValueChildrenList, true);
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            LOG.warn("Scope Request Failed.", e);
        }

//        // Iterate through each variable.
//        List<Variable> variables = myFrame.getVariables();
//        for (Variable variable : variables) {
//            // Get the scopeprocessors.
//            String scopeName = variable.getScope();
//            // Check whether the scopeprocessors is already available in the map.
//            if (scopeMap.containsKey(scopeName)) {
//                // If it is already in the map, add the variable to the corresponding list.
//                List<Variable> list = scopeMap.get(scopeName);
//                list.add(variable);
//            } else {
//                // If it is not available in the map, add it as a new entry.
//                List<Variable> list = new LinkedList<>();
//                list.add(variable);
//                scopeMap.put(scopeName, list);
//            }
//        }
//
//        // Iterate through each scopeprocessors in the map.
//        scopeMap.forEach((scopeName, variableList) -> {
//            // Create a new XValueChildrenList to hold the XValues.
//            XValueChildrenList xValueChildrenList = new XValueChildrenList();
//            // Create a new variable to represent the scopeprocessors.
//            Variable scopeVariable = new Variable();
//            // Set the variable name.
//            scopeVariable.setName(scopeName);
//            // Set the children.
//            scopeVariable.setChildren(variableList);
//            // Add the variables to the children list using a ValueGroup.
//            xValueChildrenList.addBottomGroup(new BallerinaXValueGroup(myProcess, myFrame, scopeName, scopeVariable));
//            // Add the list to the node as children.
//            node.addChildren(xValueChildrenList, true);
//        });
    }
}
