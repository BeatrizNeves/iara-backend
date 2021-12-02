package iara.filter;

import iara.AppUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

public abstract class RepositoryFilter<T>  {

    public Specification<T> get() {
        return (root, query, cb) -> {
            return dontFilter(cb);
        };
    }

    protected Predicate dontFilter(CriteriaBuilder cb) {
        return cb.isTrue(cb.literal(true));
    }

    protected Predicate equal(CriteriaBuilder cb, Expression<?> x, Object y) {
        return y == null ? dontFilter(cb) : cb.equal(x, y);
    }
    
    protected Predicate longEqual(CriteriaBuilder cb, Expression<Long> x, String y) {
        Long numericY = AppUtils.parseAsLong(y);
        return y == null ? dontFilter(cb) : cb.equal(x, numericY);
    }
    
    protected Predicate equal(CriteriaBuilder cb, Expression<Date> x, String y) {

        if (y == null) {
            return dontFilter(cb);
        }

        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        final Date dateBegin = AppUtils.parseAsDate(y + " 00:00:00", df);
        final Date dateEnd = AppUtils.parseAsDate(y + " 23:59:59", df);

        return cb.and(cb.greaterThanOrEqualTo(x, dateBegin), cb.lessThanOrEqualTo(x, dateEnd));
    }
    
    protected Predicate like(CriteriaBuilder cb, Expression<String> x, String y) {
        return y == null || y.isEmpty() ? dontFilter(cb) : cb.like(cb.upper(x), "%" + y.toUpperCase() + "%");
    }
    
    protected <E> Predicate in(CriteriaBuilder cb, Expression<E> x, Collection<E> y) {
        return y == null || y.isEmpty() ? dontFilter(cb) : x.in(y);
    }
    
    protected Predicate between(CriteriaBuilder cb, Expression<Date> x, String dateBegin, String dateEnd) {
        return cb.and(greaterThanOrEqualTo(cb, x, dateBegin), lessThanOrEqualTo(cb, x, dateEnd));
    }

    protected Predicate greaterThanOrEqualTo(CriteriaBuilder cb, Expression<Date> x, String y) {

        if (y == null) {
            return dontFilter(cb);
        }

        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date dateBegin = AppUtils.parseAsDate(y + " 00:00:00", df);

        return cb.greaterThanOrEqualTo(x, dateBegin);
    }
    
    protected Predicate lessThanOrEqualTo(CriteriaBuilder cb, Expression<Date> x, String y) {

        if (y == null) {
            return dontFilter(cb);
        }

        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date dateEnd = AppUtils.parseAsDate(y + " 23:59:59", df);

        return cb.lessThanOrEqualTo(x, dateEnd);
    }
}