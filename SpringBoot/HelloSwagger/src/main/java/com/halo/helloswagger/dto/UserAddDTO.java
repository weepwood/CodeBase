package com.halo.helloswagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Halo
 * @date Created in 2021/05/15 11:07 PM
 * @description
 */
@ApiModel("用户添加 DTO")
public class UserAddDTO {

    @ApiModelProperty(value = "账号", required = true, example = "yudaoyuanma")
    private String username;
    @ApiModelProperty(value = "密码", required = true, example = "nicai")
    private String password;

    public String getUsername() {
        return username;
    }

    public UserAddDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAddDTO setPassword(String password) {
        this.password = password;
        return this;
    }

}