
package com.ITPM.springbootbackend.model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PresentationShedules")
public class PresentationShedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "projectgroup")
    private String projectgroup;
    @Column(name = "tital")
    private String tital;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "venue")
    private String venue;
    @Column(name = "examinar1")
    private String examinar1;
    @Column(name = "examinar2")
    private String examinar2;
    @Column(name = "examinar3")
    private String examinar3;


}
