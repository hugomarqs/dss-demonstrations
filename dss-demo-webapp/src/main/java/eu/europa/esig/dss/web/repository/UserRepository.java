package eu.europa.esig.dss.web.repository;

import eu.europa.esig.dss.web.config.MongoConfig;
import eu.europa.esig.dss.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Component
@Import(MongoConfig.class)
public class UserRepository {
    @Autowired
    public MongoTemplate mongoTemplate;
    public User save(User user) {
        return mongoTemplate.save(user);
    }

    public User findUserByEmail(String email){
        return mongoTemplate.findOne(query(where("email").is(email)), User.class);
    }

}
