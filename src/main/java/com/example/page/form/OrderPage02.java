package com.example.page.form;

import com.example.data.Dish;
import com.example.data.Order;
import com.example.service.IService;
import com.example.service.Service;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LambdaModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.util.List;

public class OrderPage02 extends WebPage {
	private static final long serialVersionUID = -5689897487887700459L;

	public OrderPage02() {
		IService service = new Service();
		Order order = new Order();

		IModel<List<Dish>> dishes = LoadableDetachableModel.of(service::fetchDishes);

		queue(new Form<Order>("form", Model.of(order)) {
			private static final long serialVersionUID = 3905585843235778328L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				setResponsePage(new CompletionPage(getModel()));
			}
		});
		queue(new FeedbackPanel("feedback"));
		queue(new TextField<>("userName", LambdaModel.of(order::getUserName, order::setUserName)).setRequired(true));
		queue(new Label("numberOfDish", dishes.getObject()::size));
		queue(new RadioChoice<>("dish", LambdaModel.of(order::getDish, order::setDish), dishes).setSuffix("<br/>").setRequired(true));
	}


}
