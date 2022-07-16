package com.hacker.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zero
 * @since 2022-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("returnmessage")
@ApiModel(value="Returnmessage对象", description="")
public class Returnmessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;

    @ApiModelProperty(value = "错误吗")
    @TableField("message_code")
    private String messageCode;

    @ApiModelProperty(value = "错误描述")
    @TableField("message_desc")
    private String messageDesc;


    public static final String ID = "id";

    public static final String CODE = "message_code";

    public static final String DESC = "message_desc";

}
