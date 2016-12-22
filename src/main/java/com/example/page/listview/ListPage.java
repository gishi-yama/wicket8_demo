package com.example.page.listview;

import com.example.data.Dish;
import com.example.service.IService;
import com.example.service.Service;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import java.util.List;

public class ListPage extends WebPage {
	private static final long serialVersionUID = 809218935650800573L;

	public ListPage() {

		IService service = new Service();

		IModel<List<Dish>> dishesModel = LoadableDetachableModel.of(service::fetchDishes);

		add(new ListView<Dish>("dishList", dishesModel) {

			@Override
			protected void populateItem(ListItem<Dish> listItem) {
				listItem.add(new Label("dish", listItem.getModel()));
			}
		});

	}
}
