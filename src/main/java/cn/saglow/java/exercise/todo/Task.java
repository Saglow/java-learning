package cn.saglow.java.exercise.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Description:
 * Author: HW
 * Date: 2023/7/27
 * @author HW
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// todo 去掉@Builder 能让代码执行通过
public class Task {
    private UUID uuid;
    private String name;
    private Boolean isCompleted;
    private LocalDateTime createDate;
    private LocalDateTime completeDate;
    private String author;
    public String displayInfo() {
        String isCompletedMark = this.getIsCompleted() ? " [√] " : " [ ] ";
        return this.getIsCompleted() ?
                isCompletedMark + this.getName() + " 创建时间： " + this.getCreateDate() + " 完成时间： " + this.getCompleteDate()
                :
                isCompletedMark + this.getName() + " 创建时间： " + this.getCreateDate();
    }

}
