public class IoC_Example1 {

    // Reference here: https://www.liaoxuefeng.com/wiki/1252599548343744/1282381977747489
    /*
    Spring提供的容器又称为IoC容器，什么是IoC？
    IoC全称Inversion of Control，直译为控制反转。那么何谓IoC？在理解IoC之前，我们先看看通常的Java组件是如何协作的。
    我们假定一个在线书店，通过BookService获取书籍：
    */
    public class BookService {
        // 为了从数据库查询书籍，BookService持有一个DataSource。为了实例化一个HikariDataSource，又不得不实例化一个HikariConfig。
        private HikariConfig config = new HikariConfig();
        private DataSource dataSource = new HikariDataSource(config);

        public Book getBook(long bookId) {
            try (Connection conn = dataSource.getConnection()) {
                //...
                return book;
            }
        }
    }
    public class UserService {
        private HikariConfig config = new HikariConfig();
        private DataSource dataSource = new HikariDataSource(config);
        // 因为UserService也需要访问数据库，因此，我们不得不也实例化一个HikariDataSource。
        public User getUser(long userId) {
            try (Connection conn = dataSource.getConnection()) {
                //...
                return user;
            }
        }
    }

    /*
    因为UserService也需要访问数据库，因此，我们不得不也实例化一个HikariDataSource。
    在处理用户购买的CartServlet中，我们需要实例化UserService和BookService：
    */

    public class CartServlet extends HttpServlet {
        private BookService bookService = new BookService();
        private UserService userService = new UserService();

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            long currentUserId = getFromCookie(req);
            User currentUser = userService.getUser(currentUserId);
            Book book = bookService.getBook(req.getParameter("bookId"));
            cartService.addToCart(currentUser, book);
            //...
        }
    }
    /*

    在IoC模式下，控制权发生了反转，即从应用程序转移到了IoC容器，
    所有组件不再由应用程序自己创建和配置，而是由IoC容器负责，
    这样，应用程序只需要直接使用已经创建好并且配置好的组件。
    为了能让组件在IoC容器中被“装配”出来，需要某种“注入”机制，
    例如，BookService自己并不会创建DataSource，
    而是等待外部通过setDataSource()方法来注入一个DataSource：   
    */
    public class BookService {
        private DataSource dataSource;

        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
        }
    }


}

