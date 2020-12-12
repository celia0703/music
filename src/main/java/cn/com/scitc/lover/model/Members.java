package cn.com.scitc.lover.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Members {
    private int memberId;
    private String usersUsername;
    private Integer price;

    @Id
    @Column(name = "memberId", nullable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "users_username", nullable = false, length = 20)
    public String getUsersUsername() {
        return usersUsername;
    }

    public void setUsersUsername(String usersUsername) {
        this.usersUsername = usersUsername;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members = (Members) o;
        return memberId == members.memberId &&
                Objects.equals(usersUsername, members.usersUsername) &&
                Objects.equals(price, members.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, usersUsername, price);
    }
}
