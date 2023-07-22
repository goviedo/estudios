const Token = artifacts.require('./Token')

require('chai')
	.use(require('chai-as-promised'))
	.should()

contract('Token', ([deployer, reciever, sender]) => {

	let token = undefined
	const nameToken = 'Gonzalo Oviedo'
	const symbol = 'GOL'
	const decimals = '18'
	const totalSupply = '1000000000000000000000000'

	beforeEach(async () => {
		token = await Token.new()
	})

	describe('deployment', () => {
		it('tracks the name', async () => {
			// Leeremos el nombre del token y lo verificamos. Debiera ser GOL
			// Fetch token from blockchain
			// Read Token Name Here
			const name = await token.name()
			// Check if the token is GOL
			name.should.equal(nameToken)
		})

		it('tracks de symbol', async () => {
			const result = await token.symbol()
			result.should.equal(symbol)
		})

		it('tracks the decimals', async () => {
			const result = await token.decimals()
			result.toString().should.equal(decimals)
		})

		it('tracks the total suppky', async () => {
			const result = await token.totalSupply()
			result.toString().should.equal(totalSupply)
		})

		it('assigns the total supply to the deployer of the smart contract', async () => {
			const result = await token.balanceOf(deployer)
			result.toString().should.equal(totalSupply);
		})
	})

	describe('sending tokens', () => {
		it('transfer token balances', async()=>{
			let balanceOf
			balanceOf = await token.balanceOf(deployer)
			console.log('deployer balance', balanceOf)
			balanceOf = await token.balanceOf(reciever)
			console.log('reciever balance', balanceOf)

			await token.transfer(reciever, '1000000000000000000000000', { from: deployer });

			balanceOf = await token.balanceOf(deployer)
			console.log('deployer balance AFTER: ', balanceOf)
			balanceOf = await token.balanceOf(reciever)
			console.log('reciever balance: AFTER', balanceOf)
			

		})
	})
})