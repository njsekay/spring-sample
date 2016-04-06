package jp.co.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.dao.UserMasterDao;
import jp.co.entity.UserMaster;
import jp.co.model.IndexForm;

/**
 * ハローコントローラー
 *
 * @author ecfs-dev
 *
 */
@Controller
@EnableAutoConfiguration
public class UserController {
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String home(@RequestParam(value="name", defaultValue="World")
	// String name, Model model) {
	// model.addAttribute("name", name);
	// return "home/index";
	// }

	/** 在庫情報用Dao */
	@Autowired
	private UserMasterDao userDao;

	/**
	 * 一覧画面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "/users" })
	public String index(Model model) {

		List<UserMaster> users = userDao.selectAll();

		model.addAttribute("users", users);
		return "home/index";
	}

	/**
	 * 登録画面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/new")
	public String newUser(Model model) {
		model.addAttribute("indexForm", new IndexForm());
		return "home/new";
	}

	/**
	 * 結果画面
	 *
	 * @param indexForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute IndexForm indexForm, Model model) {
		// 登録処理
		UserMaster user = new UserMaster();

		user.setName(indexForm.getName());
		user.setEmail(indexForm.getEmail());
		user.setPassword(indexForm.getPassword());
		user.setRemarks(indexForm.getRemarks());

		userDao.insert(user);

		return "redirect:/users";
	}
}