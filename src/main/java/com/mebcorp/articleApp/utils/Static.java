package com.mebcorp.articleApp.utils;

import java.util.ArrayList;
import java.util.List;

public class Static {

	public static List<String> getErreursForException(Exception ex) {
		// on récupère la liste des messages d'erreur de l'exception
		Throwable cause = ex;
		List<String> erreurs = new ArrayList<String>();
		while (cause != null) {
			erreurs.add(cause.getMessage());
			cause = cause.getCause();
		}
		return erreurs;
	}
}

