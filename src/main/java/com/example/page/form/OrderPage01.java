package com.example.page.form;

import com.example.data.Dish;
import com.example.data.Order;
import com.example.service.IService;
import com.example.service.Service;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import java.util.List;

public class OrderPage01 extends WebPage {
  private static final long serialVersionUID = -8412714440456444538L;

  public OrderPage01() {
    IService service = new Service();
    IModel<Order> orderModel = CompoundPropertyModel.of(new Order());

    IModel<List<Dish>> dishes = LoadableDetachableModel.of(service::fetchDishes);

    // 階層が面倒なのでqueueを使っている
    queue(new Form<Order>("form", orderModel) {
      private static final long serialVersionUID = -5594856831154243209L;

      @Override
      protected void onSubmit() {
        super.onSubmit();
        setResponsePage(new CompletionPage(getModel()));
      }
    });
    queue(new FeedbackPanel("feedback"));
    queue(new TextField<>("userName").setRequired(true));
    queue(new Label("numberOfDish", dishes.getObject()::size));
    queue(new RadioChoice<>("dish", dishes).setSuffix("<br/>").setRequired(true));

  }


}
