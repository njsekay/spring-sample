package jp.co.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.dao.UserDao;
import jp.co.entity.User;
import jp.co.model.IndexForm;

/**
 * ハローコントローラー
 *
 * @author ecfs-dev
 *
 */
@Controller
@EnableAutoConfiguration
public class HelloController {
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(@RequestParam(value="name", defaultValue="World")
	// String name, Model model) {
	// model.addAttribute("name", name);
	// return "home/index";
	// }



	/** 在庫情報用Dao */
	@Autowired
	private UserDao userDao;

	/**
	 * 一覧画面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {

		List<User> data = userDao.selectAll();

		model.addAttribute("images", data);
		return "home/index";
	}

	/**
	 * 登録画面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create")
	public String create(Model model) {
		model.addAttribute("indexForm", new IndexForm());
		return "home/create";
	}

	/**
	 * 結果画面
	 *
	 * @param indexForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String indexFormSubmit(@ModelAttribute IndexForm indexForm, Model model) {
		if (indexForm.getId() == 1) {
			indexForm.setContent("お前がナンバーワンだ！");
		}
		model.addAttribute("indexForm", indexForm);
		return "home/result";
	}
}