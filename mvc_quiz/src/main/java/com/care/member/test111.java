package com.care.member;

public class test111 {
	/*
	 처음에 서비스, 레파지토리, 컨트롤러를 만들었을때 생성자 sysout을 넣어서 서버를 켰을때 빈이 잘 만들어지는지 확인하는것이 좋다.
	 autowired로 객체가 잘 주입되었는지도 sysout을 이용해 한번씩 확인하는것이 좋다.
	 MemberService는 선생님이 만드는 예시에서는 MemberService는 인터페이스로 만들고 MemberServiceImpl을 클래스로 만들어서 인터페이스를 상속받음
	 경로를 만들때 그냥 index라고만 쓰면 다른사람과 경로중복이 발생할 수 있기때문에 member/index 이런식으로 만드는게 좋다
	 
	 어노테이션이 없으면 autowired를 사용할 수 없다.
	 순서상 어노테이션들을 미리 만들어놓고 서로 연결해주기 때문에 컨트롤러-서비스-DAO중에 한개만 어노테이션을 사용하지 않으면 그것만 나중에 만들어지기 때문에
	 연결이 안된 상태라서 에러가 발생한다. 즉, 어노테이션을 쓸거면 전부다 사용해야하고 아니면 모두 new 연산을 해야한다
	 
	 위쪽에 @RequestMapping("member")를 컨트롤러 어노테이션 밑에 넣어주면 뒤에 사용하는것들은 자동으로 앞에 member/경로 로 앞에 붙게됨
	 
	 똑같은 return "member/index"를 가지는 맵핑이어도 주소가 다를 수 있다.
	 member/index 를 요청해도 index페이지를 보여주고, member/register를 요청해도 index페이지를 보여줄 수 있음.
	 (대신 포스트방식이면 주소에 직접입력하여 요청하면 허용되지 않다고 뜬다) 
	 하지만 이 경우 주소는 register인데 보이는 페이지는 index면 맞지 않기 때문에 return "redirect:/member/index"를 사용하는게 일반적임
	 단, 이렇게 경로를 쓸 경우 상대경로이기 때문에 마지막 주소만 바꿔주므로 경로를 쓸때 / 가 있는지 없는지가 중요함
	 
	 service에서 dto에 저장해서 dao로 정보를 넘겨줘도 됨.
	 
	 model객체는 데이터를 넘겨받을때만 있으면 됨. 넘겨줄때는 없어도 된다.
	 
	 list.size != 0 이라고 사용할 수 있음
	 forEach var="mem" items="${list}" ->${mem.id} ${mem.pwd} ${mem.name}
	 */
}
