package ${package};

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller - ${model_name_cn}
 * @author	pengxiaopeng
 * @version 2.0
 * @date 	${.now?string("yyyy-MM-dd")}
 */
@Controller
@RequestMapping("/admin/${lowerModel}")
public class ${model}Controller  extends BaseController{
	  @Autowired
	  private ${model}Service ${repository}Service;
	  
	  
	  
	  /**
		* 跳转添加页面
		* 
		* @param id
		* @param model
		* @return
		*/
	  @RequestMapping(value="/add", method={RequestMethod.GET})
	  public String add(ModelMap model){
	    return "/admin/${repository}/add";
	  }
	  
	  
	   /**
	 	* 添加操作
		* 
	 	* @param ${repository}
	 	* @param redirectAttributes
	 	* @return
	 	*/
	  @RequestMapping(value="/save", method={RequestMethod.POST})
	  public String save(${model} ${repository}, RedirectAttributes redirectAttributes){
	    if (!isValid(${repository}, new Class[] { BaseEntity.Save.class })){
	      return "/admin/common/error";
		}
	    this.${repository}Service.save(${repository});
	    addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
	    
	    return "redirect:list.jhtml";
	  }
	  
	  
	  /**
	 	* 跳转编辑页面
	 	* 
	 	* @param id
	 	* @param model
	 	* @return
	 	*/
	  @RequestMapping(value="/edit/{id}", method={RequestMethod.GET})
	  public String edit(@PathVariable Long id, ModelMap model){
		model.addAttribute("${repository}", this.${repository}Service.find(id));
	    return "/${lowerModel}/${repository}/edit";
	  }
	  
	  
	  /**
	 	* 修改操作
	 	* 
	 	* @param ${repository}
	 	* @param redirectAttributes
	 	* @return
	 	*/
	  @RequestMapping(value="/update", method={RequestMethod.POST})
	  public String update(${model}  ${repository},  RedirectAttributes redirectAttributes){
		${model}  persistent = (${model})this.${repository}Service.find(${repository}.getId());
	    if (persistent == null)
	      return "/admin/common/error";
	    this.${repository}Service.update(${repository});
	    addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
	    return "redirect:list.jhtml";
	  }
	  
	  
	  /**
		* 列表查询
		* 
		* @param pageable
		* @param model
		* @return
		*/
	  @RequestMapping(value="/list", method={RequestMethod.GET})
	  public String list(Pageable pageable, ModelMap model) {
	    model.addAttribute("page", this.${repository}Service.findPage(pageable));
	    return "/admin/${repository}/list";
	  }
	  
	  
	  /**
	 	* 删除操作
	 	* 
	 	* @param ids
	 	* @return
	 	*/
	  @RequestMapping(value="/delete", method={RequestMethod.POST})
	  @ResponseBody
	  public Message delete(Long[] ids)  {
	    if (ids.length >= this.${repository}Service.count())
	      return Message.error("admin.common.deleteAllNotAllowed", new Object[0]);
	    this.${repository}Service.delete(ids);
	    return SUCCESS_MESSAGE;
	  }
}
