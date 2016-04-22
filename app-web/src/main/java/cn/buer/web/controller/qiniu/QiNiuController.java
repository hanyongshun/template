package cn.buer.web.controller.qiniu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.buer.util.qiniu.QiNiuUtil;
@Controller
@RequestMapping("qiniu")
public class QiNiuController {
	@RequestMapping("upload")
	public String upload(){
		return "qiniu/upload";
	}
	@RequestMapping("uploadToken/{mimeType}")
	@ResponseBody
	public String getUploadToken(@PathVariable String mimeType){
		return QiNiuUtil.getUploadToken("buer", mimeType);
	}
}
