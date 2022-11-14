package cookingNotebook.controllers;

import java.util.Stack;

import javafx.scene.Parent;

public class BackForFun {
	private static Stack<Parent> oldRoots = new Stack<>();

	public static Parent popRoot() {
		return oldRoots.pop();
	}

	public static void pushRoot(Parent oldRoot) {
		BackForFun.oldRoots.push(oldRoot);
	}

}
