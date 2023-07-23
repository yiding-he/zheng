package com.zheng.oss.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.zheng.oss.common.constant.OssConstant;
import com.zheng.oss.common.constant.OssResult;
import com.zheng.oss.common.constant.OssResultConstant;
import com.zheng.oss.web.service.AliyunOssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangShuzheng on 2017/5/15.
 */
@Controller
@RequestMapping("/aliyun/oss")
public class AliyunOssController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AliyunOssController.class);

	@Autowired
	private AliyunOssService aliyunOssService;

	/**
	 * 签名生成
	 */
	@GetMapping("/policy")
	@ResponseBody
	@CrossOrigin(origins = "*", methods = RequestMethod.GET)
	public Object policy() {
		return aliyunOssService.policy();
	}

	/**
	 * 上传成功回调方法
	 * @param request
	 * @return
	 */
	@PostMapping("callback")
	@ResponseBody
	public Object callback(HttpServletRequest request) {
		JSONObject data = new JSONObject();
		String filename = request.getParameter("filename");
		filename = "http://".concat(OssConstant.ALIYUN_OSS_BUCKET_NAME).concat(".").concat(OssConstant.ALIYUN_OSS_ENDPOINT).concat("/").concat(filename);
		data.put("filename", filename);
		data.put("size", request.getParameter("size"));
		data.put("mimeType", request.getParameter("mimeType"));
		data.put("width", request.getParameter("width"));
		data.put("height", request.getParameter("height"));
		return new OssResult(OssResultConstant.SUCCESS, data);
	}

}
