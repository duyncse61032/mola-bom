package vn.edu.fpt.mola.bom.entity.view;

import java.time.Instant;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.StringUtils;

import vn.edu.fpt.mola.bom.entity.UserPrincipal;
import vn.edu.fpt.mola.bom.entity.enumerate.Gender;


@XmlRootElement(name = "user")
public class UserForm extends BaseEntityView<UserPrincipal>
{
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String title;
    @NotNull(message = "{validate.user.name}")
    private String firstName;
    @NotNull(message = "{validate.user.name}")
    private String lastName;
    private String nameSuffix;
    private String displayName;
    private Gender gender;
    private Instant birthday;

    @Override
    public void updateEntity(UserPrincipal entity)
    {
        UserPrincipal newEntity = this.toEntity();
        
        if (newEntity.getTitle() != null) {
            entity.setTitle(newEntity.getTitle());
        }
        if (StringUtils.hasText(newEntity.getFirstName())) {
            entity.setFirstName(newEntity.getFirstName());
        }
        if (StringUtils.hasText(newEntity.getLastName())) {
            entity.setLastName(newEntity.getLastName());
        }
        if (newEntity.getNameSuffix() != null) {
            entity.setNameSuffix(newEntity.getNameSuffix());
        }
        if (newEntity.getDisplayName() != null) {
            entity.setDisplayName(newEntity.getDisplayName());
        }
        if (newEntity.getGender() != null) {
            entity.setGender(newEntity.getGender());
        }
        if (newEntity.getBirthday() != null) {
            entity.setBirthday(newEntity.getBirthday());
        }
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getNameSuffix()
    {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix)
    {
        this.nameSuffix = nameSuffix;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Instant getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Instant birthday)
    {
        this.birthday = birthday;
    }

}
