
// 首先，我们给MailService添加一个@Component注解：
@Component
public class MailService {
    ...
}

/*

这个@Component注解就相当于定义了一个Bean，它有一个可选的名称，默认是mailService，即小写开头的类名。

然后，我们给UserService添加一个@Component注解和一个@Autowired注解：
*/