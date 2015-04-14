package me.erp.domain.model.verified;

/**
 * Created by ivan_ on 2015/4/10.
 */
public enum VerifiedType {

    ALL("全部", 0, Boolean.TRUE),
    USER_VERIFIED("用户审核", 1, Boolean.FALSE),
    MESSAGE_VERIFIED("信息审核", 2, Boolean.FALSE),
    ORGANIZATION_VERIFIED("组织审核", 3, Boolean.FALSE);

    VerifiedType(String name, int value, boolean onlyQuery) {
        this.name = name;
        this.value = value;
        this.onlyQuery = onlyQuery;
    }

    private final String name;
    private final int value;
    private final boolean onlyQuery;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isOnlyQuery() {
        return onlyQuery;
    }
}
