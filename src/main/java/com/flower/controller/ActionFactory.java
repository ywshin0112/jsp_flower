package com.flower.controller;

import com.flower.controller.action.Action;
import com.flower.controller.action.FlowerAddCategory;
import com.flower.controller.action.FlowerAddCategoryForm;
import com.flower.controller.action.FlowerAddProduct;
import com.flower.controller.action.FlowerAddProductForm;
import com.flower.controller.action.FlowerAddProductImage;
import com.flower.controller.action.FlowerAddProductImageForm;
import com.flower.controller.action.FlowerBasketAction;
import com.flower.controller.action.FlowerBouquetAction;
import com.flower.controller.action.FlowerCategoryList;
import com.flower.controller.action.FlowerClientDeleteAction;
import com.flower.controller.action.FlowerClientDeleteFormAction;
import com.flower.controller.action.FlowerClientMypageAction;
import com.flower.controller.action.FlowerClientUpdateAction;
import com.flower.controller.action.FlowerClientUpdateFormAction;
import com.flower.controller.action.FlowerDeleteCategory;
import com.flower.controller.action.FlowerIdCheckAction;
import com.flower.controller.action.FlowerIdPassCheckAction;
import com.flower.controller.action.FlowerLoginAction;
import com.flower.controller.action.FlowerLoginFormAction;
import com.flower.controller.action.FlowerLogoutAction;
import com.flower.controller.action.FlowerMainAction;
import com.flower.controller.action.FlowerMembershipAction;
import com.flower.controller.action.FlowerMembershipAgreementAction;
import com.flower.controller.action.FlowerMembershipFormAction;
import com.flower.controller.action.FlowerMoneyBoxAction;
import com.flower.controller.action.FlowerPlantAction;
import com.flower.controller.action.FlowerDeleteProduct;
import com.flower.controller.action.FlowerDeleteProductImage;
import com.flower.controller.action.FlowerFindIdAction;
import com.flower.controller.action.FlowerFindPassAction;
import com.flower.controller.action.FlowerProductForm;
import com.flower.controller.action.FlowerProductList;
import com.flower.controller.action.FlowerUpdateCategory;
import com.flower.controller.action.FlowerUpdateProduct;
import com.flower.controller.action.FlowerUpdateProductForm;
import com.flower.controller.action.FlowerUpdateProductImage;
import com.flower.controller.action.FlowerWddingBouquetAction;

public class ActionFactory {
	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("flower_main")) {
			action = new FlowerMainAction();
		} else if (command.equals("flower_bouquet")) {
			action = new FlowerBouquetAction();
		} else if (command.equals("flower_basket")) {
			action = new FlowerBasketAction();
		} else if (command.equals("flower_money_box")) {
			action = new FlowerMoneyBoxAction();
		} else if (command.equals("flower_wdding_bouquet")) {
			action = new FlowerWddingBouquetAction();
		} else if (command.equals("flower_plant")) {
			action = new FlowerPlantAction();
		} else if (command.equals("flower_product_form")) {
			action = new FlowerProductForm();
		}
		
		// 상품 카테고리 테이블
		else if (command.equals("flower_add_category_form")) {
			action = new FlowerAddCategoryForm();
		} else if (command.equals("flower_category_list")) {
			action = new FlowerCategoryList();
		} else if (command.equals("flower_add_category")) {
			action = new FlowerAddCategory();
		} else if (command.equals("flower_update_category")) {
			action = new FlowerUpdateCategory();
		} else if (command.equals("flower_delete_category")) {
			action = new FlowerDeleteCategory();
		}

		// 상품목록 테이블

		else if (command.equals("flower_product_list")) {
			action = new FlowerProductList();
		} else if (command.equals("flower_add_product_form")) {
			action = new FlowerAddProductForm();
		} else if (command.equals("flower_add_product")) {
			action = new FlowerAddProduct();
		} else if (command.equals("flower_update_product_form")) {
			action = new FlowerUpdateProductForm();
		} else if (command.equals("flower_update_product")) {
			action = new FlowerUpdateProduct();
		} else if (command.equals("flower_delete_product")) {
			action = new FlowerDeleteProduct();
		} else if (command.equals("flower_add_product_image_form")) {
			action = new FlowerAddProductImageForm();
		} else if (command.equals("flower_add_product_image")) {
			action = new FlowerAddProductImage();
		} else if (command.equals("flower_update_product_image")) {
			action = new FlowerUpdateProductImage();
		} else if (command.equals("flower_delete_product_image")) {
			action = new FlowerDeleteProductImage();
		}
		
		// 로그인
		else if (command.equals("login_page")) {
			action = new FlowerLoginFormAction();
		} else if (command.equals("login")) {
			action = new FlowerLoginAction();
		} else if (command.equals("id_Ck")) {
			action = new FlowerIdCheckAction();
		}else if (command.equals("id_pass_Ck")) {
			action = new FlowerIdPassCheckAction();
		}else if (command.equals("find_id")) {
			action = new FlowerFindIdAction();
		}else if (command.equals("find_pass")) {
			action = new FlowerFindPassAction();
		}
		// 로그아웃
		else if (command.equals("logout")) {
			action = new FlowerLogoutAction();
		}
		// 회원가입
		else if (command.equals("membership_page")) {
			action = new FlowerMembershipAgreementAction();
		} else if (command.equals("membership_write")) {
			action = new FlowerMembershipFormAction();
		} else if (command.equals("membership_completion")) {
			action = new FlowerMembershipAction();
		}
		// 마이페이지
		else if (command.equals("mypage")) {
			action = new FlowerClientMypageAction();
		}
		// 수정
		else if (command.equals("flowerClient_update_form")) {
			action = new FlowerClientUpdateFormAction();
		} else if (command.equals("flowerClient_update")) {
			action = new FlowerClientUpdateAction();
		}
		// 탈퇴
		else if (command.equals("flowerClient_delete_form")) {
			action = new FlowerClientDeleteFormAction();
		} else if (command.equals("flowerClient_delete")) {
			action = new FlowerClientDeleteAction();
		}

		return action;
	}
}
