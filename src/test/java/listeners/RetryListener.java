package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    public static int attempt = 0;
    int retryLimit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(attempt < retryLimit){
            attempt++;
            return true;
        }
        return false;
    }
}
