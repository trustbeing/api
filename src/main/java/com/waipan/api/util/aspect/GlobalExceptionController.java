package com.waipan.api.util.aspect;

import com.waipan.api.util.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:42 2018/1/25
 * @Modified By:
 */

@ControllerAdvice
public class GlobalExceptionController  {
	/** Log4j日志处理(@author: rico) */
	private static final Logger logger = Logger.getLogger(GlobalExceptionController .class);

	/**
	 * 500 - INTERNAL_SERVER_ERROR
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseResult handle(Exception ex) {
		logger.error(ex);
		return ResponseResult.returnFailure(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
	}


}
