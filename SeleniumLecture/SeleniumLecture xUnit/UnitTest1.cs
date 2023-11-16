using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
namespace SeleniumLecture
{
   

    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            ChromeOptions options = new();
            options.AddArgument("--headless");
            
            //ChromeDriver driver = new ChromeDriver(options);
            ChromeDriver driver = new ChromeDriver();
            
            driver.Navigate().GoToUrl("https://demo.guru99.com/test/login.html");

            //get the objects
            IWebElement email = driver.FindElement(By.Id("email"));
            IWebElement passwd = driver.FindElement(By.Id("passwd"));
            IWebElement SubmitLogin = driver.FindElement(By.Id("SubmitLogin"));

            //do something to the object
            email.SendKeys("lee@lee.com");
            passwd.SendKeys("password");
            SubmitLogin.Click();

            //assert that the label has the right text
            //may need to pause here

            IWebElement h3 = driver.FindElement(By.XPath("/html/body/div[4]/div/div/h3"));
            String actual = h3.Text;
            
            driver.Close();//kills the session - put above the asserts

            Assert.Equal("Successfully logged in...", actual);
            
            
        }
    }
}