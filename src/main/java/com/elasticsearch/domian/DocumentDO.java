package com.elasticsearch.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author xu rongchao
 * @date 2021/3/15 13:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDO extends BaseDomain {

    private Long id;

    private String content;
}
