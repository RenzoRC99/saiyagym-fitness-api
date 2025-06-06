package backend.Routines.Infrastructure.Entity;

import backend.Users.Infrastructure.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "routines")
@Getter
@Setter
public class RoutineEntity {
    @Id
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity user;

    private String name;

    @Column(nullable = false)
    private boolean status;

    private String description;

    @Column(name = "created_at")
    private Instant createdAt;
}
