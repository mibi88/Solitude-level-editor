/*
 * Solitude level editor - Level editor for my NES game called "Solitude"!
 * Copyright (C) 2024  Mibi88
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://www.gnu.org/licenses/.
 */

package io.github.mibi88.solitude_leveleditor;

import io.github.mibi88.mibinestools.Editor;
import io.github.mibi88.mibinestools.Window;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author mibi88
 */
public class LevelEditor extends Editor {
    private static String editorName = "Level Editor";
    JButton demo_button1;
    JButton demo_button2;
    JTabbedPane tabbedPane;
    JSplitPane splitPane;
    public LevelEditor(Window window) {
        super(window);
        setLayout(new GridLayout(1, 1));
        
        demo_button1 = new JButton("Button 1");
        demo_button2 = new JButton("Button 2");
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab 1", demo_button2);
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                demo_button1, tabbedPane);
        setEditorName("Level Editor");
        add(splitPane);
    }
    
    @Override
    public void undo() {
        System.out.println("Undo");
    }
    
    @Override
    public void redo() {
        System.out.println("Redo");
    }
    
    @Override
    public boolean newFile() {
        if(super.newFile()){
            System.out.println("New file");
            new TestClass("Test class");
        }
        return true;
    }
    
    @Override
    public boolean openFile(File file) {
        if(super.openFile(file)){
            System.out.println("Open file: " + file.getName());
        }
        return true;
    }
    
    @Override
    public void saveFile() {
        super.saveFile();
        System.out.println("Save file");
    }
    
    @Override
    public void saveAsFile(File file) {
        super.saveAsFile(file);
        System.out.println("Save as file: " + file.getName());
    }
    
    @Override
    public void copy() {
        System.out.println("Copy");
    }
    
    @Override
    public void cut() {
        System.out.println("Cut");
    }
    
    @Override
    public void paste() {
        System.out.println("Paste");
    }
    
    @Override
    public void setScale(int scale) {
        System.out.println("Set scale: " + Integer.toString(scale));
    }
    
    @Override
    public void setGrid(boolean grid) {
        System.out.println("Set grid: " + Boolean.toString(grid));
    }
    
    public static String getEditorName() {
        return editorName;
    }
    
    public static String[] getExtension() {
        return new String[]{"level"};
    }
}
