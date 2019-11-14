package com.rimi.ruiFeng.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 修改头像对象
 *
 * @author chenjin
 * @date 2019/11/13 11:08
 */
@Data
public class UpdateUserHeadVo {
    /**
     * 验证身份的动态参数
     */
    private String verification;
    /**
     * 图片字节码
     */
    private MultipartFile multipartFile;

}
