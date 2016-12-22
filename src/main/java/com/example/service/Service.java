package com.example.service;

import com.example.data.Dish;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// 通常はDIコンテナで生成するが、今回はデモなのでSerializableにして直接インスタンス化する
public class Service implements IService, Serializable {
	private static final long serialVersionUID = -2928949840850062106L;

	@Override
	public List<Dish> fetchDishes() {
		Stream<Dish> dishStream = Stream.of(
			new Dish("鳥ザンギ定食", 500),
			new Dish("豚しょうが焼き定食", 600),
			new Dish("牛皿定食", 700));
		return dishStream.collect(toList());
	}
}
