package me.erp.domain.model.verified;

/**
 * Created by ivan_ on 2015/4/10.
 */
public abstract class AbstractVerified {

    protected String id;

    protected VerifiedType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VerifiedType getType() {
        return type;
    }

    public void setType(VerifiedType type) {
        this.type = type;
    }
}
