package com.multi.biz;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.AddrlistMapper;
import com.multi.mapper.CustMapper;
import com.multi.vo.AddrlistVO;
import com.multi.vo.CustVO;

@Service
public class CustBiz implements Biz<String, CustVO> {
	@Autowired
	CustMapper dao;
	@Autowired
	AddrlistMapper adao;

	@Override
	public void register(CustVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(CustVO v) throws Exception {
		v = validateAddr(v);
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public CustVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CustVO> get() throws Exception {
		return dao.selectall();
	}

	public void modifyDefShipAddr(CustVO v) throws Exception {
		v = validateAddr(v);
		dao.updateDefShipAddr(v);
	}

	public AddrlistVO getAsAddrlistVO(String k) throws Exception {
		return dao.selectAsAddrlistVO(k);
		// aid는 0으로 나옵니다 0이면 따로 처리하는걸 코딩해야 함
	}

//	public CustVO getAdmin(String id) throws Exception {
//		return dao.getUser(id);
//	}

	public CustVO validateAddr(CustVO v) throws Exception {
		// custvo에서 id를 가져오고, custvo에서 수정할 값을 가져온다
		// addrlist에서는 목록을 찾는다
		Integer applyingAid = v.getDef_ship_addr();
		if (applyingAid == 0 || applyingAid.equals(null)) {
			v.setDef_ship_addr(0);
			return v;
		} else {
			List<AddrlistVO> addrlist = null;
			addrlist = adao.selectpercust(v.getUid());
			Optional addrvo = addrlist.stream().filter(obj -> obj.getAid() == applyingAid).findAny();
			if (addrvo.isPresent() == true) {
				return v;
			} else {
				throw new Exception("유저가 선택할 수 있는 주소 목록 중에 없습니다");
			}
		}
	}
}
