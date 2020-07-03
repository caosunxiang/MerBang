/**
 * Copyright (C), 2020-2020, 众马科技有限公司
 * FileName: InsertOffice
 * Author:   冷酷的苹果
 * Date:     2020/5/14 9:23
 * Description: 添加办公室
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cc.mrbird.febs.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 〈一句话功能简述〉<br>
 * 〈添加办公室〉
 *
 * @author 冷酷的苹果
 * @create 2020/5/14
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertOffice {

    private Integer pid;    //上级id
    private String pidType;   //  A  写字楼     B  共享办公
    private Integer floorid;  //楼栋
    private String floor;      //楼层
    private String door;       //门牌号
    private String area;         //面积
    private String state;            //状态
    private String price;    //价格

}
