package com.example.page;

import com.example.page.ajax.AjaxOrderPage;
import com.example.page.ajax.TimerPage;
import com.example.page.form.OrderPage01;
import com.example.page.form.OrderPage02;
import com.example.page.listview.ListPage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.lambda.components.ComponentFactory;


public class IndexPage extends WebPage {
  private static final long serialVersionUID = 1010314105054227997L;

  public IndexPage() {

    add(ComponentFactory.link("toListPage", (link) -> setResponsePage(new ListPage())));


    add(ComponentFactory.link("toOrderPage01", (link) -> setResponsePage(new OrderPage01())));
    add(ComponentFactory.link("toOrderPage02", (link) -> setResponsePage(new OrderPage02())));
    add(ComponentFactory.link("toAjaxOrderPage", (link) -> setResponsePage(new AjaxOrderPage())));
    add(ComponentFactory.link("toTimerPage", (link) -> setResponsePage(new TimerPage())));
  }
}
