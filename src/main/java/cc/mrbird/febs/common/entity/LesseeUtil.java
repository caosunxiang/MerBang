/**
 * Copyright (C), 2020-2020, 众马科技有限公司
 * FileName: LesseeUtil
 * Author:   冷酷的苹果
 * Date:     2020/5/27 11:31
 * Description: 租户页面租控图
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cc.mrbird.febs.common.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈租户页面租控图〉
 *
 * @author 冷酷的苹果
 * @create 2020/5/27
 * @since 1.0.0
 */
@Data
public class LesseeUtil {

    private String floor;
    private String area;

    private List<Map<String, Object>> list;
}
