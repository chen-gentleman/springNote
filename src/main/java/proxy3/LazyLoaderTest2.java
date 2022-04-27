package proxy3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

/**博客的内容一般比较多，需要用到内容的时候，我们再去加载，下面来模拟博客内容延迟加载的效果。
 * @author @Chenxc
 * @date 2022年04月27日 22:22
 */
public class LazyLoaderTest2 {
    public static class BlogModel{
        private String title;
        //博客内容信息比较多，需要的时候再去获取
        private BlogContentModel blogContentModel;
        public BlogModel() {
            this.title = "spring aop详解!";
            this.blogContentModel = this.getBlogContentModel();
        }

        public BlogContentModel getBlogContentModel(){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(BlogContentModel.class);
            enhancer.setCallback(new LazyLoader() {
                @Override
                public Object loadObject() throws Exception {
                    //此处模拟从数据库中获取博客内容
                    System.out.println("开始从数据库中获取博客内容.....");
                    BlogContentModel result = new BlogContentModel();
                    result.setContent("欢迎大家和我一起学些spring，我们一起成为spring 高手！");
                    return  result;
                }
            });
            return (BlogContentModel)enhancer.create();
        }
    }

    //表示博客内容信息
    public static class BlogContentModel {
        //博客内容
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


    public static void main(String[] args) {
        BlogModel blogModel = new BlogModel();
        System.out.println(blogModel.title);
        System.out.println("博客内容");
        System.out.println(blogModel.getBlogContentModel().getContent());
    }

    }
