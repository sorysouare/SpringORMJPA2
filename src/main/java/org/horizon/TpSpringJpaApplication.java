package org.horizon;

import org.horizon.dao.TeamRepository;
import org.horizon.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class TpSpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(TpSpringJpaApplication.class, args);

		TeamRepository dao=ctx.getBean(TeamRepository.class);
		dao.save(new Team(null,"FC Porto"));
		dao.save(new Team(null,"FC Bayern"));
		dao.save(new Team(null,"Paris FC"));
		dao.save(new Team(null,"Milan"));
		dao.save(new Team(null,"Juventus"));

		List<Team> teamList=dao.getTeamsByName("FC");
		for(Team team:teamList){
			System.out.println("Team: "+team.getName());
		}
	}

}
