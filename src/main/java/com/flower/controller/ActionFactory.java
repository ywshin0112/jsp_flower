package com.flower.controller;

import com.flower.controller.action.Action;
import com.flower.controller.action.FlowerAddCategory;
import com.flower.controller.action.FlowerAddCategoryForm;
import com.flower.controller.action.FlowerBasketAction;
import com.flower.controller.action.FlowerBouquetAction;
import com.flower.controller.action.FlowerCategoryList;
import com.flower.controller.action.FlowerDeleteCategory;
import com.flower.controller.action.FlowerMainAction;
import com.flower.controller.action.FlowerMoneyBoxAction;
import com.flower.controller.action.FlowerPlantAction;
import com.flower.controller.action.FlowerProductForm;
import com.flower.controller.action.FlowerWddingBouquetAction;

public class ActionFactory {
private ActionFactory() {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("flower_main")) {
			action = new FlowerMainAction();
		} else if(command.equals("flower_bouquet")) {
			action = new FlowerBouquetAction();
		} else if(command.equals("flower_basket")) {
			action = new FlowerBasketAction();
		} else if(command.equals("flower_money_box")) {
			action = new FlowerMoneyBoxAction();
		} else if(command.equals("flower_wdding_bouquet")) {
			action = new FlowerWddingBouquetAction();
		} else if(command.equals("flower_plant")) {
			action = new FlowerPlantAction();
		} else if(command.equals("flower_product_form")) {
			action = new FlowerProductForm();
		} else if(command.equals("flower_add_category_form")) {
			action = new FlowerAddCategoryForm();
		} else if(command.equals("flower_category_list")) {
			action = new FlowerCategoryList();
		} else if(command.equals("flower_add_category")) {
			action = new FlowerAddCategory();
		} else if(command.equals("flower_delete_category")) {
			action = new FlowerDeleteCategory();
		}
		 
		
		return action;
	}
}
