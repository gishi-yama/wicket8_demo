package com.example.page8.form;

import com.example.data.Order;
import com.example.page8.IndexPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

public class CompletionPage extends WebPage {

	public CompletionPage(IModel<Order> orderModel) {
		add(new Label("userName", orderModel.getObject()::getUserName));
		add(new Label("dish", orderModel.getObject()::getDish));
		add(Link.onClick("toIndexPage", (link) -> setResponsePage(IndexPage.class)));
	}
}
