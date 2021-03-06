package app.core.aspects;

import java.sql.SQLException;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.dao.company.Company;

@Component
@Aspect
@Order(1)
public class LoggerAspect {

	@Before("app.core.aspects.MyPointcuts.addOrDeleteOrLogin()")
	public void logAddRemoveLoginAdvice() {
		System.out.println(">>>Logger Advice: add/delete/login");
	}

	@After("execution(* app.core.dao.company.CompanyDao.getAllCompanies(..))")
	public void findCompaniesAfterFinalyAdvice(JoinPoint jp) {
		System.out.println(">>>AfterFinalyAdvice on method: " + jp.getSignature().getName());
	}

	@AfterReturning(pointcut = "app.core.aspects.MyPointcuts.collectionGetters()", returning = "col")
	public void getCollectionAdvice(JoinPoint jp, Collection<?> col) {
		for (Object e : col) {
			System.out.println(e);
			if (e instanceof Company) {
				Company company = (Company) e;
				company.setName(company.getName().toLowerCase());
			}
		}
	}

	@AfterThrowing(pointcut = "app.core.aspects.MyPointcuts.collectionGetters()", throwing = "t")
	public void getCollectionFailedAdvice(JoinPoint jp, Throwable t) {
		if (t instanceof SQLException) {
			System.out.println("send sms to database crew");
		}
		System.out.println(">>> getCollectionFailedAdvice on " + jp.getSignature().getName() + "- ex " + t);
	}

}
