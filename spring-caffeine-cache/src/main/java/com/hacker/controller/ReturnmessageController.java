package com.hacker.controller;


import com.hacker.result.R;
import com.hacker.utils.CaffeineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zero
 * @since 2022-07-17
 */
@RestController
@RequestMapping("/returnmessage")
public class ReturnmessageController {

    @Autowired
    private CaffeineUtils caffeineUtils;

    @GetMapping("/get/{code}")
    public R<String> getDesc(@PathVariable String code) {
        return R.ok(caffeineUtils.getReturnDesc(code));
    }

}

