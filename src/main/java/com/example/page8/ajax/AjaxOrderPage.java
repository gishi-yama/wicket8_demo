package com.example.page8.ajax;

import com.example.data.Dish;
import com.example.data.Order;
import com.example.page8.IndexPage;
import com.example.service.IService;
import com.example.service.Service;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.util.List;

public class AjaxOrderPage extends WebPage {
	private static final long serialVersionUID = 1L;

	public AjaxOrderPage() {
		IService service = new Service();

		IModel<Order> orderModel = CompoundPropertyModel.of(Model.of(new Order()));
		IModel<List<Dish>> dishes = LoadableDetachableModel.of(service::fetchDishes);

		Form<Order> form = new Form<>("form", orderModel);
		add(form);
		form.add(new FeedbackPanel("feedback"));
		form.add(new TextField<>("userName").setRequired(true));
		form.add(new Label("numberOfDish", dishes.getObject()::size));
		form.add(new RadioChoice<>("dish", dishes).setSuffix("<br/>").setRequired(true));
		form.add(AjaxButton.onSubmit("onSubmit", (b, t) -> t.add(getPage().get("wmc"))));


		WebMarkupContainer wmc = new WebMarkupContainer("wmc", orderModel) {
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
				setOutputMarkupPlaceholderTag(true);
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				System.out.println(orderModel.getObject().getUserName());
				setVisibilityAllowed(!orderModel.getObject().getUserName().equals(""));
			}
		};


		add(wmc);
		wmc.add(new Label("userName"));
		wmc.add(new Label("dish"));
		wmc.add(Link.onClick("toIndexPage", (link) -> setResponsePage(IndexPage.class)));
	}


}
