package com.revature.app;

import java.util.ArrayList;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		ArrayList<Object> books = new ArrayList<>();

		Javalin app = Javalin.create();

		app.start();

		app.post("/books", ctx -> {
			// our input is going to be coming in as "form parameters"
			books.add(ctx.formParam("title"));
			books.add(ctx.formParam("author"));
			books.add(ctx.formParam("genre"));
			books.add(Integer.parseInt(ctx.formParam("publishDate")));
			
			String responseText = "";

			for (Object eachBook : books) {
				System.out.println(eachBook);

				if (eachBook != null) {
					responseText += eachBook + "<br>";
				}
			}
			ctx.html(responseText);
		});
	}

}
