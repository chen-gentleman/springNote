package beanLife.fuziBean;

/**
 * @author @Chenxc
 * @date 2022年04月26日 20:34
 */
public class LessonModel {
    //课程名称
    private String name;
    //课时
    private int lessonCount;
    //描述信息
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLessonCount() {
        return lessonCount;
    }

    public void setLessonCount(int lessonCount) {
        this.lessonCount = lessonCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LessonModel{" +
                "name='" + name + '\'' +
                ", lessonCount=" + lessonCount +
                ", description='" + description + '\'' +
                '}';
    }
}
