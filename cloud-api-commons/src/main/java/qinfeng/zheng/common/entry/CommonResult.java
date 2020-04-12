package qinfeng.zheng.common.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private String port;
    private T data;

    public CommonResult(Integer code, String message, String port) {
        this(code, message, port, null);
    }
}
