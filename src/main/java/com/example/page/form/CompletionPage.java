package com.example.page.form;

import com.example.data.Order;
import com.example.page.IndexPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class CompletionPage extends WebPage {
	private static final long serialVersionUID = 3057979294465321296L;

	public CompletionPage(IModel<Order> orderModel) {
		setDefaultModel(CompoundPropertyModel.of(orderModel));
		add(new Label("userName"));
		add(new Label("dish"));
		add(Link.onClick("toIndexPage", (link) -> setResponsePage(IndexPage.class)));
	}
}
