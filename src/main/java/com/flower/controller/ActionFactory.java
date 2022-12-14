package com.flower.controller;

import com.flower.controller.action.Action;
import com.flower.controller.action.FlowerAddCategory;
import com.flower.controller.action.FlowerAddCategoryForm;
import com.flower.controller.action.FlowerAddProduct;
import com.flower.controller.action.FlowerAddProductForm;
import com.flower.controller.action.FlowerAddProductImage;
import com.flower.controller.action.FlowerAddProductImageForm;
import com.flower.controller.action.FlowerBouquetAction;
import com.flower.controller.action.FlowerBuyForm;
import com.flower.controller.action.FlowerCategoryList;
import com.flower.controller.action.FlowerClientBoardFormAction;
import com.flower.controller.action.FlowerClientDeleteAction;
import com.flower.controller.action.FlowerClientDeleteFormAction;
import com.flower.controller.action.FlowerClientMypageAction;
import com.flower.controller.action.FlowerClientUpdateAction;
import com.flower.controller.action.FlowerClientUpdateFormAction;
import com.flower.controller.action.FlowerDeleteCategory;
import com.flower.controller.action.FlowerIdCheckAction;
import com.flower.controller.action.FlowerIdPassCheckAction;
import com.flower.controller.action.FlowerInquiryAction;
import com.flower.controller.action.FlowerInquiryForm;
import com.flower.controller.action.FlowerLoginAction;
import com.flower.controller.action.FlowerLoginFormAction;
import com.flower.controller.action.FlowerLogoutAction;
import com.flower.controller.action.FlowerMainAction;
import com.flower.controller.action.FlowerMainProductForm;
import com.flower.controller.action.FlowerMembershipAction;
import com.flower.controller.action.FlowerMembershipAgreementAction;
import com.flower.controller.action.FlowerMembershipFormAction;
import com.flower.controller.action.FlowerDeleteProduct;
import com.flower.controller.action.FlowerDeleteProductImage;
import com.flower.controller.action.FlowerFindIdAction;
import com.flower.controller.action.FlowerFindPassAction;
import com.flower.controller.action.FlowerProductForm;
import com.flower.controller.action.FlowerProductList;
import com.flower.controller.action.FlowerReviewAction;
import com.flower.controller.action.FlowerReviewForm;
import com.flower.controller.action.FlowerSelectCategory;
import com.flower.controller.action.FlowerUpdateCategory;
import com.flower.controller.action.FlowerUpdateProduct;
import com.flower.controller.action.FlowerUpdateProductForm;
import com.flower.controller.action.FlowerUpdateProductImage;

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
		} else if (command.equals("flower_product_form")) {
			action = new FlowerProductForm();
		} else if (command.equals("flower_main_product_form")) {
			action = new FlowerMainProductForm();
		}
		
		// ?????? ???????????? ?????????
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
		} else if (command.equals("flower_category_select")) {
			action = new FlowerSelectCategory();
		}

		// ???????????? ?????????

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
		// ?????? ?????? ?????????
		else if (command.equals("flower_buy_form")) {
			action = new FlowerBuyForm();
		}else if (command.equals("flower_review_form")) {
			action = new FlowerReviewForm();
		}else if (command.equals("flower_review_action")) {
			action = new FlowerReviewAction();
		}else if (command.equals("flower_inquiry_form")) {
			action = new FlowerInquiryForm();
		}else if (command.equals("flower_inquiry_action")) {
			action = new FlowerInquiryAction();
		}
		
		// ?????????
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
		// ????????????
		else if (command.equals("logout")) {
			action = new FlowerLogoutAction();
		}
		// ????????????
		else if (command.equals("membership_page")) {
			action = new FlowerMembershipAgreementAction();
		} else if (command.equals("membership_write")) {
			action = new FlowerMembershipFormAction();
		} else if (command.equals("membership_completion")) {
			action = new FlowerMembershipAction();
		}
		// ???????????????
		else if (command.equals("mypage")) {
			action = new FlowerClientMypageAction();
		}
		// ??????
		else if (command.equals("flowerClient_update_form")) {
			action = new FlowerClientUpdateFormAction();
		} else if (command.equals("flowerClient_update")) {
			action = new FlowerClientUpdateAction();
		}
		// ??????
		else if (command.equals("flowerClient_delete_form")) {
			action = new FlowerClientDeleteFormAction();
		} else if (command.equals("flowerClient_delete")) {
			action = new FlowerClientDeleteAction();
		}
		// ???????????????
				else if (command.equals("client_board_form")) {
				action = new FlowerClientBoardFormAction();
				}

		return action;
	}
}
