package com.example.page8;

import com.example.data.Order;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

public class CompletionPage extends WebPage {

	public CompletionPage(IModel<Order> orderModel) {
		queue(new Label("userName", orderModel.getObject()::getUserName));
		queue(new Label("dish", orderModel.getObject()::getDish));
		queue(Link.onClick("toHomePage", (link) -> setResponsePage(HomePage.class)));
	}
}
