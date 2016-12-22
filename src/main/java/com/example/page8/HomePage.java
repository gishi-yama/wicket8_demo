package com.example.page8;

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
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.util.List;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	private IModel<Order> orderModel;

	public HomePage() {
		IService service = new Service();
		orderModel = Model.of(new Order());

		IModel<List<Dish>> dishes = LoadableDetachableModel.of(service::fetchDishes);

		queue(new Form<>("form"));
		queue(new FeedbackPanel("feedback"));
		queue(new TextField<>("userName").setRequired(true));
		queue(new Label("numberOfDish", dishes.getObject()::size));
		queue(new RadioChoice<>("dish", dishes).setSuffix("<br/>").setRequired(true));
		queue(Button.onSubmit("onSubmit", (button) -> setResponsePage(new CompletionPage(orderModel))));
	}


}
